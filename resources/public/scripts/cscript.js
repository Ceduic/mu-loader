$(document).ready(function(){
	$("#navigation").on("click", "li.upload", function(event){
		$("#uploadblock").css("display", "block");
	});
	$("#close").on("click", "i", function(event){
		$("#uploadblock").css("display", "none");
	});


var uploadfiles = document.querySelector('#fileinput');
uploadfiles.addEventListener('change', function () {
    $('#submit').css("display", "block");
	var files = this.files;
	var file = this.files[0];
	console.log("name : " + file.name);
    for(var i=0; i<files.length; i++){
        previewImage(this.files[i], file.name);
    }

}, false);

function previewImage(file, name) {
    var galleryId = "gallery";

    var gallery = document.getElementById(galleryId);
    var imageType = /image.*/;

    if (!file.type.match(imageType)) {
        throw "File Type must be an image";
    }
	var galrow = document.createElement("div");
	galrow.classList.add('u-max-full-width'); 

	
    var thumb = document.createElement("div");
    thumb.classList.add('thumbnail'); 
	thumb.classList.add('three'); 
	thumb.classList.add('columns');
	
    var img = document.createElement("img");
    img.file = file;
    thumb.appendChild(img);
	galrow.appendChild(thumb);
	
	var details = document.createElement("div");
	details.classList.add('details');
	details.classList.add('nine');
	details.classList.add('columns');
	
	var par = document.createElement("p");
	txt = document.createTextNode(name);
	par.appendChild(txt);
	//var namepar = name+' text';
	//$('.details').text('test');
	//console.log(name+' text');
	//details.appendChild(name.type());
	details.appendChild(par);
	galrow.appendChild(details);
	
	gallery.appendChild(galrow);

    // Using FileReader to display the image content
    var reader = new FileReader();
    reader.onload = (function(aImg) { return function(e) { aImg.src = e.target.result; }; })(img);
    reader.readAsDataURL(file);
}	

});