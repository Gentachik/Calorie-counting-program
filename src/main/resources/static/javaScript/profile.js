'use strict';

async function fetchUserData(userId) {
    try {
        const res = await fetch(`http://localhost:8080/api/user/${userId}`);
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
    document.getElementById('firstName').innerText = user.firstName;
    document.getElementById('lastName').innerText = user.lastName;
    document.getElementById('email').innerText = user.email;
    document.getElementById('gender').innerText = user.gender;
    document.getElementById('weight').innerText = user.weight;
    document.getElementById('age').innerText = user.age;
    document.getElementById('height').innerText = user.height;
    document.getElementById('goal').innerText = user.goal;
    document.getElementById('timeToReachGoal').innerText = user.timeToReachGoal;
    document.getElementById('weightToChange').innerText = user.weightToChange;
    document.getElementById('dislikedFood').innerText = `${user.dislikedFoods.name} ${user.dislikedFoods.calorie}, ${user.dislikedFoods.protein}, ${user.dislikedFoods.fat}, ${user.dislikedFoods.carbohydrate}`;
    if (user.createdFoods && user.createdFoods.length > 0) {
        const createdFoodsHTML = user.createdFoods.map(food => {
            return `${food.name} ${food.calorie}, ${food.protein}, ${food.fat}, ${food.carbohydrate}`;
        }).join(' | ');

        document.getElementById('createdFoods').innerText = `| ${createdFoodsHTML}`;
    } else {
        document.getElementById('createdFoods').innerText = '| No created foods';
    }
}

function getUserIdFromPath() {
    const path = window.location.pathname;
    const segments = path.split('/');
    return segments[segments.length - 1];
}

function insertForm(userId) {
    const formHTML = `
        <form action="/profile/${userId}/newFood" method="get">
            <button type="submit">Create new Food</button>
        </form>
    `;
    const newFoodDiv = document.querySelector('.newFood');
    newFoodDiv.innerHTML = formHTML;
}

async function init() {
    const id = getUserIdFromPath();
    const user = await fetchUserData(id);
    displayUser(user);
    insertForm(id);
}

document.addEventListener('DOMContentLoaded', init);