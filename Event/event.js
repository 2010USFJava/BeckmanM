function pow(event){
    element = event.currentTarget;
    element.style.backgroundColor = "blue";
    //alert(element.id);
}
function changeBackground(event) {
    element = event.currentTarget;
    var r = (Math.floor(Math.random() * 255));
    var g =  (Math.floor(Math.random() * 255));
    var b =(Math.floor(Math.random() * 255));
    document.body.style.backgroundColor = "rgb(" + r + "," + g + "," + b + ")";
 }
 this.document.getElementById("C").addEventListener("mouseover", changeBackground, true);
 this.document.getElementById("B").addEventListener("click", fontStyle, true);
 //(Math.floor(Math.random() * 255)) 

function fontStyle(){
    element.style.fontFamily = "Impact,Charcoal,sans-serif";

}

window.addEventListener("resize", () => {
     document.getElementById("text").innerHTML = Math.random();  
});

//anonymous function
window.onload = function(){
    //useCapture/Event Propagation - false - bubbling, target to root
                                    // true- cpaturing, root to target
    // this.document.getElementById("A").addEventListener("click", pow, true);
    // this.document.getElementById("B").addEventListener("click", pow, true);
  //  this.document.getElementById("C").addEventListener("click", pow, true);
   // this.document.getElementById("D").addEventListener("click", pow, true);
//    this.document.getElementById("C").addEventListener("mouseover", changeBackground, true);
 //   this.document.getElementById("B").addEventListener("mouseover", pow, true);
}   

 
