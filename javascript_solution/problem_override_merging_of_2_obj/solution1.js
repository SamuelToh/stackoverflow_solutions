function MyPlugin(options) {
    options = options || {};

    if (typeof userOpt !== 'object') {
        options = {};
    }

    var defaults = {
        prop1: true,
        prop2: false,
        prop3: 0,
        prop4: 100
    };

    // Set default options
    for (var name in defaults) {
        defaults[name] = options.hasOwnProperty(name) ? options[name] : defaults[name];
    }
}

MyPlugin({
    prop1: false,
    prop4: 300
});
