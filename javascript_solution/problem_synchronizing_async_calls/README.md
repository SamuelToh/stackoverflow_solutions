Problem statement:

Given an asynchronize function called isMemberFree() that returns either true/false
  And a sychronize function called test() that calls isMemberFree()
 When I call test(), it should recursively call the async isMemberFree() fn until it returns TRUE or 10seconds has exceeded
 Then I can move on with the code.
  

Problem URL: 
http://stackoverflow.com/questions/37902092/how-to-do-a-for-loop-with-asynchronous-condition-in-javascript/37902417#37902417

Comment:
Controlling asynchronize function calls in a sychronized manner.


Caller's example code:
waitForFreeAccnt.prototype.isMemberFree = function () {
    var self = this;

    self.api.getMemberInfo(function () {
        var accType = self.api.connect.accountType;
        console.log(accType);
        if (accType === 'FREE') {
            console.log('it is free');
            return true;
        } else {
            console.log('it is not free');
            return false;
        }
    });
};


var test = function () {
    for (var start = 1; start < 10; start++) {
        var result = self.isMemberFree();
        console.log(result);
        if (result) {
            break;
        } else {
            self.api.pause(1000);
            console.log('waiting');
        }
    }
};