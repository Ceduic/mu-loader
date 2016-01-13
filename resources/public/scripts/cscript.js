$(document).ready(function(){
	$("#navigation").on("click", "li.upload", function(event){
		$("#uploadblock").css("display", "block");
	});
	$("#close").on("click", "i", function(event){
		$("#uploadblock").css("display", "none");
	});


var uploadfiles = document.querySelector('#fileinput');
uploadfiles.addEventListener('change', function () {
    var files = this.files;
    for(var i=0; i<files.length; i++){
        previewImage(this.files[i]);
    }

}, false);

function previewImage(file) {
    var galleryId = "gallery";

    var gallery = document.getElementById(galleryId);
    var imageType = /image.*/;

    if (!file.type.match(imageType)) {
        throw "File Type must be an image";
    }

    var thumb = document.createElement("div");
    thumb.classList.add('thumbnail'); 
	// Add the class thumbnail to the created div
	
    var img = document.createElement("img");
    img.file = file;
    thumb.appendChild(img);
    gallery.appendChild(thumb);
	
	var details = document.createElement("div");
	details.classList.add('details');
	var name = document.createElement("p");
	name = files.name;
	$('details').append(name);
	gallery.appendChild(details);

    // Using FileReader to display the image content
    var reader = new FileReader();
    reader.onload = (function(aImg) { return function(e) { aImg.src = e.target.result; }; })(img);
    reader.readAsDataURL(file);
}	

});