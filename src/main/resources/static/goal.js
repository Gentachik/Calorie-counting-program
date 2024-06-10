'use strict';

document.addEventListener('DOMContentLoaded', function() {
    const goalElement = document.getElementById('goal');

    ['change', 'load'].forEach(ev => goalElement.addEventListener(ev, function (){
        const selectedGoal =  goalElement.value;
        const weightElement = document.querySelector('.goal__weight');

        if(weightElement)
            weightElement.remove();

        if(selectedGoal === 'gainWeight' || selectedGoal === 'loseWeight'){
                goalElement.insertAdjacentHTML('afterend',
                    `<div class="goal__weight">
                        <label for="weightToChange">Weight (kg, only not negative values) to ${selectedGoal==='gainWeight' ? 'get' : 'lose'}:</label>
                        <input type="number" step="0.01" id="weightToChange" name="weightToChange" required />
                    </div>`);
        }
    }));
});
