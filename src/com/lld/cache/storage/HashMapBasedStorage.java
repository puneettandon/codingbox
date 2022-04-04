package com.lld.cache.storage;

import com.lld.cache.exceptions.NotFoundException;
import com.lld.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value>  implements  Storage<Key,Value> {

    Map<Key,Value> cacheStorageMap = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        cacheStorageMap.put(key,value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        cacheStorageMap.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return cacheStorageMap.get(key);
    }
}

