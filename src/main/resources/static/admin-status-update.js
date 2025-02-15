document.addEventListener("DOMContentLoaded", function() {
    const updateForms = document.querySelectorAll(".update-status-form");

    updateForms.forEach(form => {
        form.addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent form from refreshing page
            
            const requestId = this.dataset.id;
            const selectedStatus = this.querySelector("select").value;
            
            fetch(`/admin/update-status/${requestId}`, {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: `status=${selectedStatus}`
            })
            .then(response => {
                if (response.ok) {
                    alert("Status updated successfully!");
                    location.reload(); // Reload page to reflect changes
                } else {
                    alert("Failed to update status. Try again!");
                }
            });
        });
    });
});
