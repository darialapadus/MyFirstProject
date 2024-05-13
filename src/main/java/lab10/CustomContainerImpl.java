package lab10;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

public class CustomContainerImpl implements CustomContainer {
    private Map<Class<?>, Object> instances;
    private Map<String, Object> namedInstances;
    private Map<Class<?>, Function<CustomContainer, ?>> factories;

    public CustomContainerImpl() {
        instances = new HashMap<>();
        namedInstances = new HashMap<>();
        factories = new HashMap<>();
    }

    @Override
    public <T> boolean addInstance(T instance) {
        if (instance == null) {
            throw new IllegalArgumentException("Instance cannot be null");
        }

        Class<?> type = instance.getClass();
        if (instances.containsKey(type)) {
            throw new IllegalStateException("Instances cannot be redeclared");
        }

        instances.put(type, instance);
        return true;
    }

    @Override
    public <T> boolean addInstance(T instance, String customName) {
        if (instance == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (customName == null || customName.isEmpty()) {
            return addInstance(instance);
        }

        if (namedInstances.containsKey(customName)) {
            throw new IllegalStateException("Instances cannot be redeclared");
        }

        namedInstances.put(customName, instance);
        return true;
    }

    @Override
    public <T> T getInstance(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (instances.containsKey(type)) {
            return type.cast(instances.get(type));
        }

        if (factories.containsKey(type)) {
            Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factories.get(type);
            T instance = factoryMethod.apply(this);
            addInstance(instance);
            return instance;
        }

        throw new IllegalStateException("Cannot provide instance");
    }

    @Override
    public <T> T getInstance(Class<T> type, String customName) {
        if (type == null || customName == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (namedInstances.containsKey(customName)) {
            Object instance = namedInstances.get(customName);
            if (type.isInstance(instance)) {
                return type.cast(instance);
            } else {
                throw new IllegalStateException("Invalid type for object");
            }
        }

        if (factories.containsKey(type)) {
            Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factories.get(type);
            T instance = factoryMethod.apply(this);
            addInstance(instance, customName);
            return instance;
        }

        throw new IllegalStateException("Cannot provide instance");
    }

    @Override
    public <T> boolean addFactoryMethod(Class<T> type, Function<CustomContainer, T> factoryMethod) {
        if (type == null || factoryMethod == null) {
            throw new IllegalArgumentException("Null is not allowed as a parameter");
        }

        if (factories.containsKey(type)) {
            throw new IllegalStateException("Factory method already exists for type");
        }

        factories.put(type, factoryMethod);
        return true;
    }

    @Override
    public <T> T create(Class<T> type) {
        return null;
    }

    @Override
    public <T> T create(Class<T> type, Map<String, Object> parameters) {
        if (type == null) {
            throw new IllegalArgumentException("Type cannot be null");
        }

        if (parameters == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        if (factories.containsKey(type)) {
            Function<CustomContainer, T> factoryMethod = (Function<CustomContainer, T>) factories.get(type);
            return factoryMethod.apply(this);
        }

        throw new IllegalStateException("Cannot provide instance");
    }

    @Override
    public void close() throws Exception {
        for (Object instance : instances.values()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
        for (Object instance : namedInstances.values()) {
            if (instance instanceof AutoCloseable) {
                ((AutoCloseable) instance).close();
            }
        }
    }
}
