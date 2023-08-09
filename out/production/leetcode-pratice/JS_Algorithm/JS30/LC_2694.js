class EventEmitter {
    events = {}
    subscribe(event, cb) {
        if(!this.events[event])  this.events[event] = []
        this.events[event].push(cb)
        return {
            unsubscribe: () => {
                this.events[event] = this.events[event].filter(v => v !== cb)
            }
        };
    }

    emit(event, args = []) {
        return (this.events[event] ?? []).map(v => v(...args))
    }
}

