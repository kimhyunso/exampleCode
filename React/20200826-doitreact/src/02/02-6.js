function Shape(x,y){
    this.name = 'Shape';
    this.move(x,y);
}

Shape.create = function(x,y) {return new Shape(x,y);};
Shape.prototype.move = function(x,y){
    this.x = x;
    this.y = y;
}
Shape.prototype.area = function(){
    return 0;
}

Shape.prototype = {
    move : function(x,y){
        this.x = x;
        this.y = y;
    },
    area: function(x,y){
        return 0;
    }
}

var s = new Shape(0,0);
s.area();


