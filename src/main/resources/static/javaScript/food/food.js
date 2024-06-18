document.addEventListener("DOMContentLoaded", function () {
    const preferenceDiv = document.querySelector(".preference");
    const foodId = window.location.href.split('/').pop();

    function createPreferenceButton(isDisliked) {
        const button = document.createElement("button");
        button.textContent = isDisliked ? "Change to dislike" : "Change to like";
        button.addEventListener("click", function () {
            changePreference(foodId);
        });
        preferenceDiv.appendChild(button);
    }

    function changePreference() {
        fetch(`/api/food/${foodId}/preference`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => response.json())
            .then(data => {
                const button = preferenceDiv.querySelector("button");
                button.textContent = data ? "Like" : "Dislike";
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }
    function containsFoodId(foodIds) {
        for (let i = 0; i < foodIds.length; i++) {
            if (foodIds[i] === foodId) {
                return true;
            }
        }
        return false;
    }
    fetchFoodDetails();

    function fetchFoodDetails() {
        fetch("/api/user/get-current-dislikes", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(foodIds => {
                if (containsFoodId(foodIds, foodId))
                    createPreferenceButton(true);
                else
                    createPreferenceButton(false);
        })
            .catch(error => {
                console.error('Error:', error);
            });
    }
});