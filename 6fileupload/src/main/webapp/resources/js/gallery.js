
let slideIndex = 1;

Array.from(document.getElementsByClassName("slideshow-container")).forEach(
    function(element, index) {
    	console.log(index);
        showSlides(index+1,slideIndex)
    }
);

// Next/previous controls
function plusSlides(a,n) {
  showSlides(a,slideIndex += n);
}

// Thumbnail image controls
function currentSlide(a,n) {
  showSlides(a,slideIndex = n);
}
function showSlides(a,n) {
  let i;
  let slides = document.querySelectorAll("#item" + a + " > .mySlides");
  let dots = document.querySelectorAll("#item" + a + "  .dot");
  if (n > slides.length) {slideIndex = 1}
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";
  dots[slideIndex-1].className += " active";
} 