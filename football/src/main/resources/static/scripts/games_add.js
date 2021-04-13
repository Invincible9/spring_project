$(document).ready(function() {

    // let teams = [];
    // let divisions = [];
    // $.get(getNationalitiesURL, function(data) {
    //     insertOptionsToSelect({
    //         'data': data,
    //         'selectId': '#homeTeamNationality'
    //     });
    //     insertOptionsToSelect({
    //         'data': data,
    //         'selectId': '#awayTeamNationality'
    //     });
    //     insertOptionsToSelect({
    //         'data': data,
    //         'selectId': '#nationality'
    //     });
    // });


    // when choosing nationality then the divisions must appear
    $('#homeTeamNationality').on('change', function() {
        let homeTeamNationalityId = $(this).val();
        fetch("http://localhost:8080/divisions/" + homeTeamNationalityId)
            .then(response => response.json())
            .then(data => {
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#homeTeamDivision',
                    'name': 'Home Division'
                });
            })
    });

    $('#awayTeamNationality').on('change', function() {
        let awayTeamNationalityId = $(this).val();
        fetch("http://localhost:8080/divisions/" + awayTeamNationalityId)
            .then(response => response.json())
            .then(data => {
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#awayTeamDivision',
                    'name': 'Away Division'
                });
            })
    });

    // //when choosing division then the teams must appear
    $('#homeTeamDivision').on('change', function(el) {
        let selectedDivisionId = $(this).val();
        fetch("http://localhost:8080/teams/" + selectedDivisionId)
            .then(response => response.json())
            .then(data => {
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#homeTeam',
                    'name': 'Home Team'
                });
            });
    });


    // //when choosing division then the teams must appear
    $('#awayTeamDivision').on('change', function() {
        let selectedDivisionId = $(this).val();
        fetch("http://localhost:8080/teams/" + selectedDivisionId)
            .then(response => response.json())
            .then(data => {
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#awayTeam',
                    'name': 'Away Team'
                });
            });
    });

    $('#homeTeam').on('change', function() {
        let selectedTeamId = $(this).val();
        fetch("http://localhost:8080/teams/team/" + selectedTeamId)
            .then(response => response.json())
            .then(data => {
                let homeTeamLogoContainer = $('#homeTeamLogoCont');
                homeTeamLogoContainer.empty();
                homeTeamLogoContainer.append(`<img class="img-responsive img-fluid" src="${data.logoUrl}" width="100%" alt="missing image"/>`);
            });
    });

    $('#awayTeam').on('change', function() {
        let selectedTeamId = $(this).val();
        fetch("http://localhost:8080/teams/team/" + selectedTeamId)
            .then(response => response.json())
            .then(data => {
                let homeTeamLogoContainer = $('#awayTeamLogoCont');
                homeTeamLogoContainer.empty();
                homeTeamLogoContainer.append(`<img class="img-responsive img-fluid" src="${data.logoUrl}" width="100%" alt="missing image"/>`);
            });
    });

    $('#homeTeamScoreGoalsMinutes').on('change', function() {
        $('#awayTeamAllowGoalsMinutes').val($(this).val());
    });

    $('#homeTeamAllowGoalsMinutes').on('change', function(){
        $('#awayTeamScoreGoalsMinutes').val($(this).val());
    });

    $('#awayTeamAllowGoalsMinutes').on('change', function() {
        $('#homeTeamScoreGoalsMinutes').val($(this).val());
    });

    $('#awayTeamScoreGoalsMinutes').on('change', function(){
        $('#homeTeamAllowGoalsMinutes').val($(this).val());
    });

    $('#homeTeamPossession').on('change', function() {
        $('#awayTeamPossession').val(100 - $(this).val());
    });

    $('#awayTeamPossession').on('change', function() {
        $('#homeTeamPossession').val(100 - $(this).val());
    });

    $('#homeTeamGoals').on('change', function(){
        let homeTeamGoals = parseInt($(this).val());
        let awayTeamGoals = parseInt($('#awayTeamGoals').val());
        let gameWinnerSelect = $('#w');
        if(homeTeamGoals > awayTeamGoals){
            gameWinnerSelect.val('1');
            return;
        }
        if(homeTeamGoals < awayTeamGoals){
            gameWinnerSelect.val('2');
            return;
        }
        gameWinnerSelect.val('x');
    });

    $('#awayTeamGoals').on('change', function(){
        let awayTeamGoals = parseInt($(this).val());
        let homeTeamGoals = parseInt($('#homeTeamGoals').val());
        let gameWinnerSelect = $('#winner');
        if(homeTeamGoals > awayTeamGoals){
            gameWinnerSelect.val('1');
            return;
        }
        if(homeTeamGoals < awayTeamGoals){
            gameWinnerSelect.val('2');
            return;
        }
        gameWinnerSelect.val('x');
    });

    //about rounds
    $('#nationality').on('change', function() {
        let nationalityId = $(this).val();
        fetch("http://localhost:8080/divisions/" + nationalityId)
            .then(response => response.json())
            .then(data => {
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#division',
                    'name': 'Nationality'
                });
            })
    });

    //about rounds
    $('#division').on('change', function() {
        let divisionId = $(this).val();
        console.log(divisionId)
        fetch("http://localhost:8080/seasons/" + divisionId)
            .then(response => response.json())
            .then(data => {
                console.log(data)
                insertOptionsToSelect({
                    'data': data,
                    'selectId': '#season',
                    'name': 'Division'
                });
            })
    });


    // $('#season').on('change', function() {
    //     let selectedSeasonId = $(this).val();
    //     $.get(getRoundBySeasonURL + selectedSeasonId, function(data) {
    //         insertOptionsToSelect({
    //             'data': data,
    //             'selectId': '#round'
    //         });
    //     });
    // });


});

function insertOptionsToSelect(info) {
    let {
        data,
        selectId,
        name
    } = info;

    $(selectId).empty();
    $('<option>').val('').text('Choose ' + name).appendTo(selectId);
    for (let context of data) {

        $('<option>').val(context.id).text(context.name).appendTo(selectId);
    }
}