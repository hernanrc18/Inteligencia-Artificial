var Tablero;
const Player = 'O';
const Comp = 'X';
const combosGanadores = [
	[0, 1, 2],
	[3, 4, 5],
	[6, 7, 8],
	[0, 3, 6],
	[1, 4, 7],
	[2, 5, 8],
	[0, 4, 8],
	[6, 4, 2]
]

const celdas = document.querySelectorAll('.celda');
iniciarJuego();


function iniciarJuego() {
	document.querySelector(".juegoterminado").style.display = "none";
	Tablero = Array.from(Array(9).keys());
	for (var i = 0; i < celdas.length; i++) {
		celdas[i].innerText = '';
		celdas[i].style.removeProperty('background-color');
		celdas[i].addEventListener('click', cambiarTurno, false);	
	}
}


function cambiarTurno(casilla) {
    if(typeof Tablero[casilla.target.id] == 'number'){
        //turn(casilla.target.id, Player)
		turn(mejorLugar('O'), Player)
        if(!revisarEmpate()) turn(mejorLugar('X'), Comp);
    }
}

function turn(casillaId, player) {
	if (player=='O') {
		celdas[casillaId].style.color = 'blue';
	}
	else {
		celdas[casillaId].style.color = 'red';	
	}
	Tablero[casillaId] = player;
	document.getElementById(casillaId).innerText = player;
	let juegoGanado = revisarGanador(Tablero, player)
	if (juegoGanado) juegoTerminado(juegoGanado)
}

function revisarGanador(Tablero, player) {
	let plays = Tablero.reduce((a, e, i) => 
		(e === player) ? a.concat(i) : a, []);
	let juegoGanado = null;
	for (let [index, win] of combosGanadores.entries()) {
		if (win.every(elem => plays.indexOf(elem) > -1)) {
			juegoGanado = {index: index, player: player};
			break;
		}
	}
	return juegoGanado;
}

function juegoTerminado(juegoGanado) {
	for (let index of combosGanadores[juegoGanado.index]) {
		document.getElementById(index).style.backgroundColor =
			juegoGanado.player == Player ? "skyblue" : "pink";
	}
	for (var i = 0; i < celdas.length; i++) {
		celdas[i].removeEventListener('click', cambiarTurno, false);
	}
	declararGanador(juegoGanado.player == Player ? "Ganaste!" : "Perdiste!");
}

function mejorLugar(players){
		if (players=='O') {
			return minmax(Tablero, Player).index;	}
		else {
			return minmax(Tablero, Comp).index;	
	}
    
}

function casillasVacias(){
    return Tablero.filter(s => typeof s == 'number');
}

function revisarEmpate(){
    if(casillasVacias().length == 0){
        for(var i=0; i<celdas.length; i++){
			celdas[i].style.backgroundColor = "lightgray";
			celdas[i].removeEventListener('click', cambiarTurno, false);
		}
		declararGanador("Juego Empatado!");
		return true;
	}
	return false;
}

function declararGanador(ganadorP){
	document.querySelector(".juegoterminado").style.display = "block";
	document.querySelector(".juegoterminado .text").innerText = ganadorP;
}

function minmax(newTablero, player){
	var casillaDisponible = casillasVacias();
	if(revisarGanador(newTablero, Player)){
		return {score: -10};
	}else if(revisarGanador(newTablero, Comp)){
		return {score: 20};
	}else if( casillaDisponible.length === 0){
		return {score: 0};
	}

	var movimientos = [];
	for(var i=0; i< casillaDisponible.length; i++){
		var movimiento = {};
		movimiento.index= newTablero[casillaDisponible[i]];
		newTablero[casillaDisponible[i]] = player;

		if(player == Comp){
			var result = minmax(newTablero, Player);
			movimiento.score = result.score;
		}else{
			var result = minmax(newTablero, Comp);
			movimiento.score = result.score;
		}

		newTablero[casillaDisponible[i]] = movimiento.index;
		movimientos.push(movimiento);
	}

	var mejorMovimiento;
	if(player === Comp){
		var mejorScore = -1000;
		for(var i=0; i<movimientos.length; i++){
			if(movimientos[i].score > mejorScore){
				mejorScore = movimientos[i].score;
				mejorMovimiento = i;
			}
		}
	}else{
		var mejorScore = 1000;
		for(var i=0; i<movimientos.length; i++){
			if(movimientos[i].score < mejorScore){
				mejorScore = movimientos[i].score;
				mejorMovimiento = i;
			}
		}
	}

	return movimientos[mejorMovimiento];
}