'use strict';

async function fetchUserData() {
    try {
        const res = await fetch(`http://localhost:8080/api/user/get-current`);
        if (!res.ok) {
            throw new Error('Network response was not ok ' + res.statusText);
        }
        const data = await res.json();
        return {
            firstName: data.firstName,
            lastName: data.lastName,
            email: data.email,
            gender: data.gender,
            age: data.age,
            weight: data.weight,
            height: data.height,
            goal: data.goal,
            timeToReachGoal: data.timeToReachGoal,
            weightToChange: data.weightToChange,
            dislikedFoods: data.dislikedFoods,
            createdFoods: data.createdFoods,
        };
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function displayUser(user) {
    document.getElementById('firstName').innerText = `First Name: ${user.firstName}`;
    document.getElementById('lastName').innerText = `Last Name: ${user.lastName}`;
    document.getElementById('email').innerText = `Email: ${user.email}`;
    document.getElementById('weight').innerText = `Weight: ${user.weight} kg`;
    document.getElementById('age').innerText = `Age: ${user.age} years`;
    document.getElementById('height').innerText = `Height: ${user.height} cm`;
    document.getElementById('goal').innerText = `Goal: ${user.goal}`;

    if (user.gender) {
        document.getElementById('gender').innerText = `Gender: ${user.gender}`;
    } else {
        document.getElementById('gender').innerText = '';
    }

    if (user.timeToReachGoal) {
        document.getElementById('timeToReachGoal').innerText = `Time to Reach Goal: ${user.timeToReachGoal} months`;
    } else {
        document.getElementById('timeToReachGoal').innerText = '';
    }

    if (user.goal !== 'maintainWeight') {
        document.getElementById('weightToChange').innerText = `Weight to Change: ${user.weightToChange} kg`;
    } else {
        document.getElementById('weightToChange').innerText = '';
    }

    if (user.dislikedFoods && user.dislikedFoods.length > 0) {
        const dislikedFoodsHTML = user.dislikedFoods.map(food => {
            return `${food.name} (Calories: ${food.calorie}, Protein: ${food.protein}g, Fat: ${food.fat}g, Carbs: ${food.carbohydrate}g)`;
        }).join(', ');

        document.getElementById('dislikedFood').innerText = `Disliked Foods: ${dislikedFoodsHTML}`;
    } else {
        document.getElementById('dislikedFood').innerText = 'Disliked Foods: None';
    }

    if (user.createdFoods && user.createdFoods.length > 0) {
        const createdFoodsHTML = user.createdFoods.map(food => {
            return `${food.name} (Calories: ${food.calorie}, Protein: ${food.protein}g, Fat: ${food.fat}g, Carbs: ${food.carbohydrate}g)`;
        }).join(' | ');

        document.getElementById('createdFoods').innerText = `Created Foods: ${createdFoodsHTML}`;
    } else {
        document.getElementById('createdFoods').innerText = 'Created Foods: None';
    }
}

function insertForm() {
    const formHTML = `
        <form action="/profile/new-food" method="get">
            <button type="submit">Create new Food</button>
        </form>
    `;
    const newFoodDiv = document.querySelector('.newFood');
    newFoodDiv.innerHTML = formHTML;
}

async function init() {
    const user = await fetchUserData();
    displayUser(user);
    insertForm();
}

document.addEventListener('DOMContentLoaded', init);