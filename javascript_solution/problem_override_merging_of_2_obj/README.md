Problem statement:

Given an object (default object) that contains a list of properties 
When a user passed down another object with a list of properties
Then the code should override the user's object property value to the defeault object
 And merge whatever that is not already in the default object.<br>
  
<br>
Problem URL:__ 
http://stackoverflow.com/questions/38044713/merge-default-with-user-defined-settings/38044798#38044798
<br>
Comment:__
Merge array, override property values to the original array

<br>

Caller's example code:
```javascript
function MyPlugin(options) {
  if (typeof optoins === null || typeof options !== 'object') options = {};

    var defaults = {
       prop1: true,
       prop2: false,
       prop3: 0,
       prop4: 100,
    }
  // Set default options
  for (var name in defaults) {
      !(name in options) && (this.options[name] = defaults[name]);
  }
}

var test = new MyPlugin();
```
