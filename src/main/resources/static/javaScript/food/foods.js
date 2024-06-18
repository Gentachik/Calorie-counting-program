'use strict';

const form = document.querySelector('.search');
const results = document.querySelector('.results');

const getQuery = function () {
    const query = form.querySelector('.search__field').value;
    form.querySelector('.search__field').value = '';
    return query;
}

const loadSearchResults = async function (query) {
    const res = await fetch(`http://localhost:8080/api/food?search=${query}`);
    return res.json();
}

const searchResults = async function () {
    const query = getQuery();
    results.innerHTML = '';
    const data = await loadSearchResults(query);
    if (data.length === 0) {
        results.insertAdjacentHTML('afterbegin', `<li>No food for '${query}' were found</li>`);
        return;
    }
    results.innerHTML = '<h1>Foods:</h1>';
    data.forEach(food => {
        results.insertAdjacentHTML('beforeend', `<li class="food">
                    <a class="preview__link" href="food/${food.id}">
                        <div class="preview__data">
                            <h4 class="preview__name">${food.name}</h4>
                            <h6>${food.calorie} calories</h6> 
                            <h6>${food.protein}g protein</h6> 
                            <h6>${food.fat}g fat</h6> 
                            <h6>${food.carbohydrate}g carbohydrate</h6> 
                        </div>
                    </a>
                </li>`);
    });
}

const getResults = async function () {
    form.addEventListener('submit', function (e) {
        e.preventDefault();
        searchResults();
    })
}

getResults();