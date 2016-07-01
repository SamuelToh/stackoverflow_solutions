Problem statement:

Given 2 data points that have same date timestamp (milliseconds since epoch)
When a user tries to write them into the influx database
Then influx database write 1 of the point
 And influx database overrides the written point with the other point due the point having same timestamp.
  
<br>
Problem URL:__ 
http://stackoverflow.com/questions/38065339/how-to-writenodejs-multiple-points-having-same-timestamp-in-influxdb/38067999#38067999
<br>
Comment:__
Data points with same date timestamp, caller wants to record both of them into the database but influx's default behavior is that it will override one over another if the date timestamp are the same.

Caller seems to assume that when doing a write using node-influx module, a javascript's date time object is needed. User is aware that his point data's date timestamp are unique, they are differentiated by
micro-seconds. Since javascript's date time object only supports granularity of milliseconds, caller suspects it is not possible to write the data.

Others proposed him to tag the data with different value to make them unique, hence tricking influx to store the 2 point data.

I proposed - since influx could store data up till nanoseconds, ignoring date object's limitation (since not required by node-influx) just pass in 64 bit integer value and ask node-influx to write them.
<br>

Caller's example code:
Not provided.
