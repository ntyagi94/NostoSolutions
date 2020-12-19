i18next.init({
  lng: 'en',
  debug: true,
  resources: {
    en: {
      translation: {
        "source-text": "Source Currency",
        "target-text": "Kohdevaluutta",
        "amount-text": "määrä",
        "result-text": "Result: ",
        "submit-text": "Submit"
      }
    },
    fi: {
      translation: {
        "source-text": "Lähdevaluutta",
        "target-text": "Kohdevaluutta",
        "amount-text": "määrä",
        "result-text": "Tulos",
        "submit-text": "Lähetä"
      }
    }
  }
}, function(err, t) {
  updateContent();
});

function updateContent() {
  $("#sourceLbl").text(i18next.t('source-text'));
  $("#targetLbl").text(i18next.t('target-text'));
  $("#amountTxt").text(i18next.t('target-text'));
  $("#resultTitle").text(i18next.t('result-text'));
  $(".btn-primary").text(i18next.t('submit-text'));
}

function changeLng(lng) {
  i18next.changeLanguage(lng);
}

i18next.on('languageChanged', () => {
  updateContent();
});

function isFloat(n){
    return Number(n) === n && n % 1 !== 0;
}

function formatResponseErrors(result){
	$("#errorlist").append(`<p>${result}</p>`);
}

$( "#frm-input-data" ).submit(function( event ) {
	event.preventDefault();
	const source = $('#source').val();
	const target = $('#target').val();
	const amount = $('#amount').val();
	let errorsForm = false;
	
	// Front-End Validations
	
	if(!source) {
		formatResponseErrors("Source cannot be empty!");
		errorsForm = true;
	} 
	if(!target) {
		formatResponseErrors("Target cannot be empty!");
		errorsForm = true;
	} 
	if(!amount) {
		formatResponseErrors("Amount cannot be empty!");
		errorsForm = true;
	} 
	if(errorsForm) {
		return;
	}
	
	// Contact API 
	
	const urlRequest = `/api/v1/convert?source=${source}&target=${target}&amount=${amount}`;
	
	$.ajax({
		  method: "GET",
		  url: urlRequest,
		})
		  .done(function( result ) {
			  // Validate result
			  if(result.status===false) {
				  formatResponseErrors(result.errors);
			  }
			  // Show result
			  if(result.status==true) {
				  $("#resultContainer").show();
				  $("#resultConvertion").text(result.content);
			  }
		  });
});