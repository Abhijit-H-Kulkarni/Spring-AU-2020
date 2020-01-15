var Names = ["Abhijit","Akshat","Kiran","Kaushal","Rahul","Sandeep","Zain","Saurabh"];

var string = "";
Names.forEach(function (item,index){
string = string+(index+1).toString()+". "+item+"\n";
});


function find(){
var keyword = document.getElementById("keyword").value;
if(keyword==""){
    document.getElementById("names").innerHTML = string;
}
else{
    var regEx = new RegExp(keyword);
    var result = Names.filter(function(item){
        return regEx.test(item);
    });
    string = "";
    result.forEach(function (item,index){
        string = string+(index+1).toString()+". "+item+"\n";
        });
    document.getElementById("names").innerHTML = string;
}
}