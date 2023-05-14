var x = 0;
var y = 0;
var obj = {x:x,y:y};
var randomKeyString  = 'other';
var combined = {};
combined['one'+randomKeyString] = 'some value';
var obj2 = {
    x:x,
    methodA: function(){console.log('methodA');},
    methodB: function(){return 0;},
};

console.log(obj2);






