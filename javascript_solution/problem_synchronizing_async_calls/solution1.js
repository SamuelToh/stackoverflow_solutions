waitForFreeAccnt.prototype.isMemberFree = function (done) {
    var self = this;

    self.api.getMemberInfo(function () {
        var accType = self.api.connect.accountType;
        console.log(accType);
        if (accType === 'FREE') {
            console.log('it is free');
            return done(null, true);
        } else {
            console.log('it is not free');
            return done(null, false);
        }
    });
};

var test = function () {

    var testMembership = function(waitAttempt, isFree) {
        if (isFree) { 
            return; 
        }
        else if (waitAttempt > 10) {
            // wait exceeded, do something.
            return;
        }
        setTimeout(function() {
            self.isMemberFree(function(err, isFree) {
                testMembership(waitAttempt+=1, isFree);
            });
        }, /*total milliseconds in 1sec=*/1000);
    }

    testMembership(/*WaitAttempts=*/0, /*isFree=*/false);
};