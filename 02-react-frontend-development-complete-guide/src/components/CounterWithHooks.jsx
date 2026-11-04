import React, { useState, useEffect, useMemo, useCallback } from 'react';

/**
 * Demonstrates useState, useEffect, useMemo, and useCallback hooks.
 */
export default function CounterWithHooks() {
  const [count, setCount] = useState(0);
  const [multiplier, setMultiplier] = useState(2);

  // useCallback prevents re-creating the function unless dependency changes
  const handleIncrement = useCallback(() => {
    setCount(prev => prev + 1);
  }, []);

  const handleReset = useCallback(() => {
    setCount(0);
  }, []);

  // useMemo caches expensive calculation results
  const computedValue = useMemo(() => {
    // Simulated calculation
    return count * multiplier;
  }, [count, multiplier]);

  // useEffect runs side effects
  useEffect(() => {
    document.title = `Count: ${count} | CodeByTushu`;
  }, [count]);

  return (
    <div className="demo-box">
      <h4>⚡ Interactive Hooks Sandbox (useState + useMemo + useCallback)</h4>
      <div className="counter-controls">
        <span className="count-display">Current Count: <strong>{count}</strong></span>
        <button onClick={handleIncrement} className="btn-action">+1 Increment</button>
        <button onClick={handleReset} className="btn-action reset">Reset</button>
      </div>
      <div className="memo-controls">
        <label>
          Multiplier:
          <select value={multiplier} onChange={(e) => setMultiplier(Number(e.target.value))}>
            <option value={2}>2x</option>
            <option value={5}>5x</option>
            <option value={10}>10x</option>
          </select>
        </label>
        <p className="memo-result">Memoized Result ({count} &times; {multiplier}) = <strong>{computedValue}</strong></p>
      </div>
    </div>
  );
}
