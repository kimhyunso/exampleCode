function parse(qs){
    /*var queryString = qs.substr(1);
    var chunks = qs.split('&');
    var result = {};*/
    /*for(var i = 0; i<chunks.length; i++){
        var parts = chunks[i].split('=');
        var key = parts[0];
        //var value = parts[1];
        var value = Number.isNaN(Number(parts[1])) ? parts[1] : Number(parts[1]);
        result[key] = value;
    }*/

    /*const queryString = qs.substr(1);
    const chunks = queryString.split('&');
    let result = {};
    chunks.forEach((chunks) =>{
        const parts = chunks.split('=');
        const key = parts[0];
        const value = Number.isNaN(Number[parts[1]]) ? parts[1] : Number(parts[1]);
        result[key] = value;
    });*/
    /*const queryString = qs.substr(1);
    const chunks = queryString.split('&');
    let result = {};
    chunks.forEach((chunks)=>{
        const[key,value] = chunks.split('=');
        result[key] = value;
    });*/

    /*const queryString = qs.substr(1);
    const chunks = qs.split('&');
    const result = chunks.map((chunks)=>{
        const[key,value] = chunks.split('=');
        return {key:key,value:value};
    });*/
    const queryString = qs.substr(1);
    const chunks = qs.split('&');
    return chunks
        .map((chunks) =>{
            const[key,value] = chunks.split('=');
            return {key,value};
        })
        .reduce((result, item) =>{
            result[item.key] = item.value;
            return result;
        },{});

    //return result;
}

function sum(numbers){
    return numbers.reduce((total,num) => total+num,0);
}
console.log(parse('banana=10&apple=20&orange=30'));

//console.log(sum([1,2,3,4,5,6,7,8,9,10]));





