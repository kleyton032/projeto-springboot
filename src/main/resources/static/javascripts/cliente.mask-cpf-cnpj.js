var Cervejaria = Cervejaria || {};

Cervejaria.MaskCpfCnpj = (function() {
	
	function MaskCpfCnpj() {
		this.radioTipoPessoa = $('.js-radio-tipo-pessoa');
		this.labelCpfCnpj = $('[for=cpfOuCnpj]');
		this.inputCpfCnpj = $('#cpfOuCnpj');

	}
	
	MaskCpfCnpj.prototype.iniciar = function() {
		this.radioTipoPessoa.on('change', onTipoPessoaAlterado.bind(this));
		var tipoPessoaSelecionada = this.radioTipoPessoa.filter(':checked')[0];
		if(tipoPessoaSelecionada){
			aplicarMascara.call(this, $(tipoPessoaSelecionada));
		}
		
	}
	

	function onTipoPessoaAlterado(evento){
		var tipoPessoaSelecionada = $(evento.currentTarget);
		aplicarMascara.call(this, tipoPessoaSelecionada);
		this.inputCpfCnpj.val('');

	}
	
	function aplicarMascara(tipoPessoaSelecionada) {
		
		this.labelCpfCnpj.text(tipoPessoaSelecionada.data('documento'));
		this.inputCpfCnpj.mask(tipoPessoaSelecionada.data('mascara'));
		this.inputCpfCnpj.removeAttr('disabled');
	}
	
	
	return MaskCpfCnpj;
	
}());

$(function() {
	var MaskCpfCnpj = new Cervejaria.MaskCpfCnpj();
	MaskCpfCnpj.iniciar();
});