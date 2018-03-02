var Cervejaria = Cervejaria ||{};

Cervejaria.ComboEstado = (function() {
	
	function ComboEstado() {
		this.combo = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	}
	
	ComboCidade.prototype.iniciar = function() {
		
	}
	
	return ComboEstado;
	
	
}());

Cervejaria.ComboCidade - (function() {
	
	function ComboCidade(ComboEstado) {
		this.ComboEstado = ComboEstado;
	}
	
	ComboCidade.prototype.iniciar = function() {
		
	}
	
	return ComboCidade;
	
}());

$(function() {
	
	var ComboEstado = new Cervejaria.ComboEstado();
	ComboEstado.iniciar();
	
	var ComboCidade = new Cervejaria.ComboCidade(ComboEstado);
	ComboCidade.iniciar();
})