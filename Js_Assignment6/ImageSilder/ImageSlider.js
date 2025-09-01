const slides = document.getElementById("slides");
        const dots = document.querySelectorAll(".dot");
        const slider = document.getElementById("slider");
        const prevBtn = document.getElementById("prev");
        const nextBtn = document.getElementById("next");

        let index = 0;
        let intervalId;

        function showSlide(i) {
            slides.style.transform = `translateX(-${i * 600}px)`;
            dots.forEach(dot => dot.classList.remove("active"));
            dots[i].classList.add("active");
        }

        function nextSlide() {
            index = (index + 1) % dots.length;
            showSlide(index);
        }

        function prevSlide() {
            index = (index - 1 + dots.length) % dots.length;
            showSlide(index);
        }

        function startSlider() {
            intervalId = setInterval(nextSlide, 3000);
        }

        function stopSlider() {
            clearInterval(intervalId);
        }

        startSlider();

        slider.addEventListener("mouseenter", stopSlider);
        slider.addEventListener("mouseleave", startSlider);

        dots.forEach((dot, i) => {
            dot.addEventListener("click", () => {
                index = i;
                showSlide(index);
                stopSlider();
                startSlider();
            });
        });

        nextBtn.addEventListener("click", () => {
            nextSlide();
            stopSlider();
            startSlider();
        });

        prevBtn.addEventListener("click", () => {
            prevSlide();
            stopSlider();
            startSlider();
        });