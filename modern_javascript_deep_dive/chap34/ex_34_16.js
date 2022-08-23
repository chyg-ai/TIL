{
    [Symbol.iterator]() { return this; },
    next(){ return { value: AnalyserNode, done: boolean }; }
}