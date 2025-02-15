document.addEventListener("DOMContentLoaded", function() {
    const forms = document.querySelectorAll("form");

    forms.forEach(form => {
        form.addEventListener("submit", function(event) {
            const inputs = form.querySelectorAll("input, textarea");
            let isValid = true;

            inputs.forEach(input => {
                if (input.hasAttribute("required") && input.value.trim() === "") {
                    isValid = false;
                    alert(input.placeholder + " is required!");
                }
            });

            if (!isValid) {
                event.preventDefault(); // Stop form submission
            }
        });
    });
});
