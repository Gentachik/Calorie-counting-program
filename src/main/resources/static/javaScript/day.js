function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

async function fetchData(date) {
    try {
        const response = await fetch(`/api/day/day?date=${date}`);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const dayData = await response.json();
        displayDayDetails(dayData);
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}

function displayDayDetails(dayData) {
    document.getElementById('date').textContent = new Date(dayData.date).toLocaleDateString();
    document.getElementById('neededCalories').textContent = dayData.neededCalorie;
    document.getElementById('neededProtein').textContent = dayData.neededProtein;
    document.getElementById('neededCarbohydrate').textContent = dayData.neededCarbohydrate;
    document.getElementById('neededFat').textContent = dayData.neededFat;
    document.getElementById('tdee').textContent = dayData.tdee;
    document.getElementById('bmr').textContent = dayData.bmr;
}

const dateFromURL = getQueryParam('date');
if (dateFromURL) {
    fetchData(dateFromURL);
} else {
    console.error('No date provided in the URL');
}