var influx = require('influx');

var databaseWriter = influx({
    host: 'XXX',
    port: 'XXX',
    protocol: 'XXX',
    username: 'XXX',
    password: 'XXX',
    database: 'XXX'
});

this.databaseWriter.writePoints(
    'influx_stackoverflow_solution',
    [
        // point #1
        [
            {
                "value": 999,
                "time" : 1422568543702900257
            },
            {
                'tag1' : 'value_in_nanoseconds'
            }
        ],
        // point #2
        [
            {
                "value": 8888,
                "time" : 1422568543702900600
            },
            {
                'tag1' : 'value_in_nanoseconds'
            }
        ]
    ],
    { precision: 'ns' },
    function(errmsg, returnValue) {
        if (errmsg) return callback(new Error(errmsg));
        callback(null, returnValue);
    }
);