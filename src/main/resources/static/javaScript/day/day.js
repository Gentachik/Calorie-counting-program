function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

function formatNumber(number, decimalPlaces = 2) {
    return number.toLocaleString(undefined, {
        minimumFractionDigits: decimalPlaces,
        maximumFractionDigits: decimalPlaces
    });
}

async function fetchData(date) {
    try {
        const response = await fetch(`/api/day/day?date=${date}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        displayDayDetails(data);
        displayFoodItems(data.foods);
        displayTotals(data.foods);
        createButton(date);
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

function displayDayDetails(dayData) {
    document.getElementById('date').textContent = new Date(dayData.date).toLocaleDateString();
    document.getElementById('neededCalories').textContent = formatNumber(dayData.neededCalorie);
    document.getElementById('neededProtein').textContent = formatNumber(dayData.neededProtein);
    document.getElementById('neededCarbohydrate').textContent = formatNumber(dayData.neededCarbohydrate);
    document.getElementById('neededFat').textContent = formatNumber(dayData.neededFat);
    document.getElementById('bmi').textContent = formatNumber(dayData.bmi);
}

function displayFoodItems(foods) {
    const foodItemsContainer = document.getElementById('foodItems');
    foodItemsContainer.innerHTML = '';

    foods.sort((a, b) => new Date(a.date) - new Date(b.date));

    foods.forEach(food => {
        const actualCalories = (food.calorie * food.amount) / 100;
        const actualProtein = (food.protein * food.amount) / 100;
        const actualCarbohydrate = (food.carbohydrate * food.amount) / 100;
        const actualFat = (food.fat * food.amount) / 100;

        const foodItem = document.createElement('div');
        foodItem.classList.add('food-item')
        foodItem.innerHTML = `
            <p><strong>Food Name:</strong> ${food.name}</p>
            <p><strong>Date:</strong> ${new Date(food.date).toLocaleDateString()}</p>
            <p><strong>Calories:</strong> ${formatNumber(actualCalories)}</p>
            <p><strong>Protein:</strong> ${formatNumber(actualProtein)}</p>
            <p><strong>Carbohydrate:</strong> ${formatNumber(actualCarbohydrate)}</p>
            <p><strong>Fat:</strong> ${formatNumber(actualFat)}</p>
            <hr>
        `;
        foodItemsContainer.appendChild(foodItem);
    });
}

function displayTotals(foods) {
    const totalCalories = foods.reduce((sum, food) => sum + (food.calorie * food.amount) / 100, 0);
    const totalProtein = foods.reduce((sum, food) => sum + (food.protein * food.amount) / 100, 0);
    const totalCarbohydrate = foods.reduce((sum, food) => sum + (food.carbohydrate * food.amount) / 100, 0);
    const totalFat = foods.reduce((sum, food) => sum + (food.fat * food.amount) / 100, 0);

    const totalsContainer = document.createElement('div');
    totalsContainer.innerHTML = `
        <h3>Totals</h3>
        <p><strong>Total Calories:</strong> ${formatNumber(totalCalories)}</p>
        <p><strong>Total Protein:</strong> ${formatNumber(totalProtein)}</p>
        <p><strong>Total Carbohydrate:</strong> ${formatNumber(totalCarbohydrate)}</p>
        <p><strong>Total Fat:</strong> ${formatNumber(totalFat)}</p>
    `;

    document.getElementById('dayDetails').appendChild(totalsContainer);
}

function createButton(date) {
    const formContainer = document.createElement('div');
    formContainer.innerHTML = `
        <form action="/day/day/add-food" method="get">
            <input type="hidden" name="date" value="${date}">
            <button type="submit">Add food</button>
        </form>
    `;
    document.getElementById('dayDetails').appendChild(formContainer);
}

const dateFromURL = getQueryParam('date');
if (dateFromURL) {
    fetchData(dateFromURL);
} else {
    console.error('No date provided in the URL');
}