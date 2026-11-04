import { useState, useEffect } from 'react';

/**
 * Custom hook to synchronize state with window.localStorage.
 * 
 * @param {string} key 
 * @param {any} initialValue 
 */
export function useLocalStorage(key, initialValue) {
  const [value, setValue] = useState(() => {
    try {
      const stored = localStorage.getItem(key);
      return stored ? JSON.parse(stored) : initialValue;
    } catch (e) {
      console.error("Error reading localStorage key:", key, e);
      return initialValue;
    }
  });

  useEffect(() => {
    try {
      localStorage.setItem(key, JSON.stringify(value));
    } catch (e) {
      console.error("Error saving to localStorage key:", key, e);
    }
  }, [key, value]);

  return [value, setValue];
}
