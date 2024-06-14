'use strict';

function insertForm() {
    const formHTML = `
        <form action="/profile/newFood" method="post">
            <div>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required />
            </div>
            <div>
                <label for="calorie">Calories:</label>
                <input type="number" step="0.01" id="calorie" name="calorie" min="0">
            </div>
            <div>
                <label for="protein">Proteins:</label>
                <input type="number" step="0.01" id="protein" name="protein" min="0">
            </div>
            <div>
                <label for="fat">Fats:</label>
                <input type="number" step="0.01" id="fat" name="fat" min="0">
            </div>
            <div>
                <label for="carbohydrate">Carbohydrates:</label>
                <input type="number" step="0.01" id="carbohydrate" name="carbohydrate" min="0">
            </div>
            <button type="submit">Create new Food</button>
        </form>`;
    const newFoodDiv = document.querySelector('.newFood');
    newFoodDiv.innerHTML = formHTML;
}

function init(){
    insertForm();
}

init();