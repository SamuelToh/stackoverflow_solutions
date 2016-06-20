// A neater solution than solution1.js
waitForFreeAccnt.prototype.isMemberFree = function (cbf) {
    var self = this;
    self.api.getMemberInfo(function () {
        cbf(self.api.connect.accountType === 'FREE');
    });
};

waitForFreeAccnt.prototype.testMemberXTimes = function(maxAttempts, callback) {
  var attempts = 0;
  var self = this;
  (function attempt() {
    self.isMemberFree(function(free) {
      if (free)
        callback(true);
      else if (++attempts < maxAttempts)
        setTimeout(attempt, 1000);
      else
        callback(false);
    });
  )();
};

this.testMemberXTimes(10, function(isFree) {
  // the next part of your code here, or called from here
  // because at this point we know we've tested up to
  // ten times and isFree tells us the result
});