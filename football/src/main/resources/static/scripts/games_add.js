$(document).ready(function() {
    let homeTeamNationality = $('#homeTeamNationality').val();
    alert(homeTeamNationality)

    fetch("http://localhost:8080/divisions/" + homeTeamNationality)
        .then(response => response.json())
        .then(data => {
            console.log(data)
        })


    let teams = [];
    let divisions = [];
    $.get(getNationalitiesURL, function(data) {
        insertOptionsToSelect({
            'data': data,
            'selectId': '#homeTeamNationality'
        });
        insertOptionsToSelect({
            'data': data,
            'selectId': '#awayTeamNationality'
        });
        insertOptionsToSelect({
            'data': data,
            'selectId': '#nationality'
        });
    });


    //when choosing nationality then the divisions must appear
    $('#homeTeamNationality').on('change', function() {
        let selectedNationalityId = $(this).val();
        $.get(getDivisionsByNationalityURL + selectedNationalityId, function(data) {
            insertOptionsToSelect({
                'data': data,
                'selectId': '#homeTeamDivision'
            });
        });
    });

    $('#awayTeamNationality').on('change', function() {
        let selectedNationalityId = $(this).val();
        if(divisions.length > 0){
            insertOptionsToSelect({
                'data': divisions,
                'selectId': '#homeTeamDivision'
            });
            return;
        }
        $.get(getDivisionsByNationalityURL + selectedNationalityId, function(data) {
            insertOptionsToSelect({
                'data': data,
                'selectId': '#awayTeamDivision'
            });
        });
    });

    //when choosing divion then the teams must appear
    $('#homeTeamDivision').on('change', function() {
        let selectedDivisionId = $(this).val();
        $.get(getTeamsByDivisionURL + selectedDivisionId, function(data) {
            teams = data;
            if(data.length < 2){
                $('#other_errors').addClass('alert alert-danger');
                $('#other_errors').text('At least 2 teams are needed for a game. In this division there is only one. Please add more teams');
                $('#submitBtn').attr('disabled', true);
                return;
            }
            $('#submitBtn').attr('disabled', false);
            insertOptionsToSelect({
                'data': data,
                'selectId': '#homeTeamChoose'
            });
        });
    });


    $('#awayTeamDivision').on('change', function() {
        let selectedDivisionId = $(this).val();
        if(teams.length > 0){
            insertOptionsToSelect({
                'data': teams,
                'selectId': '#awayTeamChoose'
            });
            return;
        }

        $.get(getTeamsByDivisionURL + selectedDivisionId, function(data) {
            if(data.length < 2){
                $('#other_errors').addClass('alert alert-danger');
                $('#other_errors').text('At least 2 teams are needed for a game. In this division there is only one. Please add more teams');
                $('#submitBtn').attr('disabled', true);
                return;
            }
            $('#submitBtn').attr('disabled', false);
            insertOptionsToSelect({
                'data': data,
                'selectId': '#awayTeamChoose'
            });
        });
    });


    $('#homeTeamChoose').on('change', function() {
        let homeTeamLogoContainer = $('#homeTeamLogoCont');
        const homeTeamId = $(this).val();
        $('#homeTeam').val(homeTeamId);
        let homeTeamIndex = teams.findIndex(team => team.id === homeTeamId);
        // let teamInfo = teams.filter(team => team.id === homeTeamId);
        homeTeamLogoContainer.empty();
        homeTeamLogoContainer.append(`<img class="img-responsive img-fluid" src="${teams[homeTeamIndex].logo}" />`);
        // teams.splice(homeTeamIndex, 1);
        // $(this).attr('disabled', true);
    });


    //check if user is selected 2 equals teams for the game
    $('#awayTeamChoose').on('change', function(){
        const selectedAwayTeamId = $(this).val();
        const selectedHomeTeamId = $('#homeTeam').val();
        $('#awayTeam').val(selectedAwayTeamId);
        $('#other_errors').text('');
        let awayTeamLogoContainer = $('#awayTeamLogoCont');
        let awayTeamIndex = teams.findIndex(team => team.id === selectedAwayTeamId);
        awayTeamLogoContainer.empty();
        awayTeamLogoContainer.append(`<img class="img-responsive img-fluid" src="${teams[awayTeamIndex].logo}" />`);
        if(selectedAwayTeamId === selectedHomeTeamId){
            $('#other_errors').removeClass('alert alert-danger');
            $('#other_errors').addClass('alert alert-danger');
            $('#other_errors').text('Home and Away teams cannot be equal');
            $('#submitBtn').attr('disabled', true);
            return;
        }
        $('#submitBtn').attr('disabled', false);
        $('#other_errors').removeClass('alert alert-danger');
        // teams.splice(selectedAwayTeamId, 1);
        // $(this).attr('disabled', true);
    });

    $('#home_team_score_goals_mins').on('change', function() {
        $('#away_team_allow_goals_mins').val($(this).val());
    });

    $('#home_team_allow_goals_mins').on('change', function(){
        $('#away_team_score_goals_mins').val($(this).val());
    });

    $('#away_team_allow_goals_mins').on('change', function() {
        $('#home_team_score_goals_mins').val($(this).val());
    });

    $('#away_team_score_goals_mins').on('change', function(){
        $('#home_team_allow_goals_mins').val($(this).val());
    });

    $('#home_team_possession').on('change', function() {
        $('#away_team_possession').val(100 - $(this).val());
    });

    $('#away_team_possession').on('change', function() {
        $('#home_team_possession').val(100 - $(this).val());
    });


    $('#home_team_goals').on('change', function(){
        let homeTeamGoals = parseInt($(this).val());
        let awayTeamGoals = parseInt($('#away_team_goals').val());
        let gameWinnerSelect = $('#game_winner');
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

    $('#away_team_goals').on('change', function(){
        let awayTeamGoals = parseInt($(this).val());
        let homeTeamGoals = parseInt($('#home_team_goals').val());
        let gameWinnerSelect = $('#game_winner');
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
        let selectedNationalityId = $(this).val();
        $.get(getDivisionsByNationalityURL + selectedNationalityId, function(data) {
            insertOptionsToSelect({
                'data': data,
                'selectId': '#division'
            });
        });
    });

    $('#division').on('change', function() {
        let selectedDivisionId = $(this).val();
        $.get(getSeasonsByDivisionURL + selectedDivisionId, function(data) {
            insertOptionsToSelect({
                'data': data,
                'selectId': '#season'
            });
        });
    });

    $('#season').on('change', function() {
        let selectedSeasonId = $(this).val();
        $.get(getRoundBySeasonURL + selectedSeasonId, function(data) {
            insertOptionsToSelect({
                'data': data,
                'selectId': '#round'
            });
        });
    });


});

function insertOptionsToSelect(info) {
    let {
        data,
        selectId
    } = info;
    // $(selectId).val('');
    $(selectId).empty();
    $('<option>').val('').text('Choose').appendTo(selectId);
    for (context of data) {
        // $('<option>').val(context.id).attr('disabled', true).text(context.name).appendTo(selectId);
        $('<option>').val(context.id).text(context.name).appendTo(selectId);
    }
}