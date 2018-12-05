var host = "http://"+window.document.location.host;
var madarsApiUrl = host+"/org";
var usersApiUrl = host+"/users";
var locationsApiUrl =host+"/locations";
var feedbackApiUrl =host+"/feedback";
var orgApiUrl =host+"/org";

function renderDataTable(args) {
	var table = null; 
	if (args.hasOwnProperty("cols")) {

		table = $('#' + args.tableId).DataTable({
			"ajax" : {
				"url" : args.dataUrl,
				"dataSrc" : function(data) {

					if (args.hasOwnProperty('convertToArray')) {
						return args.convertToArray(data);
					} else {
						return data
					}
				}
			},
			 dom: 'Bfrtip',
			"columns" : args.cols,
			 destroy: true,
			 searching: false,
			 buttons: [
		            'excelHtml5',
		            'pdfHtml5',
		            'print'
		        ],
		        
		        "fnRowCallback": function(nRow, aData, iDisplayIndex, iDisplayIndexFull) {
		        	var index = iDisplayIndexFull + 1;
		        	$('td:eq(0)',nRow).html(index);
		        	return nRow;
		        	}
		});
	
	}else{
		alert("Column definitions required to display tables")
	}

	 
	return table;
}

function renderTemplate(args) {
	args["url"] = args.templateUrl, args["type"] = "GET"
	
		/*************adding id for getting records location wise *****/
		var locationId;
		var hiddenField ;

		var dummyUrl = new URL("http://"+args["url"]);
		window.locationId = dummyUrl.searchParams.get("id");
		window.hiddenField = "<input type='hidden' id='locationId' value='"+window.locationId+"'>"; 
		
		/************* end ****************************/
	
	args["success"] = function(data, status, xhr) {
		$("#body-content").empty();
		if(window.locationId!=null) data = data+window.hiddenField
		$("#body-content").append(data);
	}

	args["error"] = function(xhr, status, error) {
		console.log("Error while getting template : " + error)
	}

	makeAjaxCall(args)
}

function makeAjaxCall(args) {
	$.ajax({
		url : args.url,
		type : args.type,
		async: true,
		contentType : (args.hasOwnProperty("contentType") ? args.contentType: "text/html"),
		data : (args.hasOwnProperty("data") ? args.data : ""),
		dataType : (args.hasOwnProperty("dataType") ? args.dataType : "text"),
		dataSrc : function(data) {

			if (args.hasOwnProperty('convertToArray')) {
				return args.convertToArray();

			} else {
				return data;
			}

		},
		success : function(data, status, xhr) {
			console.log(" calling url [" + args.url + "]");
			if (args.hasOwnProperty("success")) {
				args.success(data, status, xhr)
			}

			console.log("Success for URL : [" + args.url + "]")
		},
		error : function(xhr, status, error) {

			if (args.hasOwnProperty("error")) {
				args.error(xhr, status, error)
			}

			console.log("Error while calling url [" + args.url + "]. Error : "
					+ error + ", Status Code:" + status)

		}

	});
}

function render(template) {
	renderTemplate({
		templateUrl : template
	});
}

function buildAjaxArgs(url, type, dataType, contentType, success, error) {
	return {
		url : url,
		type : type,
		success : success,
		error : error,
		dataType : dataType,
		contentType : contentType
	}
}

function makeFormJSON(formId) {
	var dataArray = {}
	$("#" + formId).find(":input").each(function(index, obj) {
	    var isDisabled = $(obj).prop('disabled');
		if(!isDisabled) {
			dataArray[$(obj).attr("id")] = $(obj).val()
		}
	})
	
	console.log(JSON.stringify(dataArray));
	
	return JSON.stringify(dataArray)
}

function userTypesCall(args) {
	$.ajax({
		url : args.url,
		type : args.type,
		async:true,
		contentType : (args.hasOwnProperty("contentType") ? args.contentType
				: "text/html"),
		data : (args.hasOwnProperty("data") ? args.data : ""),
		dataType : (args.hasOwnProperty("dataType") ? args.dataType : "text"),
		dataSrc : function(data) {

			if (args.hasOwnProperty('convertToArray')) {
				return args.convertToArray();

			} else {
				return ""
			}

		},
		success : function(data, status, xhr) {
			console.log(" calling url [" + args.url + "]");
			if (args.hasOwnProperty("success")) {
				args.success(data, status, xhr)
			}

			console.log("Success for URL : [" + args.url + "]")
		},
		error : function(xhr, status, error) {

			if (args.hasOwnProperty("error")) {
				args.error(xhr, status, error)
			}

			console.log("Error while calling url [" + args.url + "]. Error : "
					+ error + ", Status Code:" + status)

		}

	});
}

/**
 * Auto suggestion
 * @param str
 * @returns
 */
function popupAutoSuggestion(str) {
	return $.get('../locations/locations/search/' + str, function(data) {

		var availableLocations = buildLocationArray(data);
		$("#locationLabel").autocomplete({
			
			source : availableLocations,
			
			select: function (event, ui) {
				 //placing id of selected area in text box.
		        $("#location").val(ui.item.value);
		        $("#locationId").val(ui.item.value);
		        //placing selected label in text box.
		        setTimeout(() => {
		        	$("#locationLabel").val(ui.item.label);
				}, 100);
		        
		    }
		});

	});
}

/**
 * data for auto suggestion
 * @param data
 * @returns
 */
function buildLocationArray(data) {
	var arrayLength = data.data.length;
	var availableLocations = [];

	for (var i = 0; i < arrayLength; i++) {
		var tehsil = (data.data[i][3] == null) ? "" : ' <- ' + data.data[i][3];
		var areaId = (data.data[i][4]!=null) ? data.data[i][4] : data.data[i][0] + ' <- ' + data.data[i][1]+ ' <- ' + data.data[i][2];
		availableLocations.push ({ value: areaId,
								   label : data.data[i][0] + ' <- ' + data.data[i][1]+ ' <- ' + data.data[i][2] + tehsil,
								})
	
	}

	return availableLocations;
}

//filling drop downs by json response
function fillDropDown(args,dropdownId) {

	args["url"] = args.url, args["type"] = "GET"
	args["success"] = function(data, status, xhr) {
		var ddl = $("#"+dropdownId);
		 $.each(data.data, function () {
			 ddl.append($("<option></option>").val(this['id']).html(this['name']));
         });
		
		 console.log(data);
	}

	args["error"] = function(xhr, status, error) {
		console.log("Error while getting list of user types : " + error)
	}

	makeAjaxCall(args)
}



function fillSpan(args,spanId)
{
	args["url"] = args.url, args["type"] = "GET"
		args["success"] = function(data, status, xhr) {
			var span = $("#"+spanId);
		
			 $.each(data.data, function () {				
				 //span.html(this[1].toString());
				 document.getElementById("locname").innerHTML=this[1].toString();
	         });
			 console.log(data);
		}
		args["error"] = function(xhr, status, error) {
			console.log("Error while getting list of user types : " + error)
		}

		makeAjaxCall(args)
}

function fillSpanById(args,spanId)
{

	args["url"] = args.url, args["type"] = "GET"
		args["success"] = function(data, status, xhr) {
			var span = $("#"+spanId);
			 debugger;
			 document.getElementById(spanId).innerHTML = data.data["name"];
		}
		args["error"] = function(xhr, status, error) {
			console.log("Error while getting list of user types : " + error)
		}

		makeAjaxCall(args);
}


function returnMarkazName(args,spanId)
{
		debugger;
		args["url"] = args.url, args["type"] = "GET"
		args["success"] = function(data, status, xhr) {			 
			document.getElementById(spanId).innerHTML = data.data["name"];
		}
		args["error"] = function(xhr, status, error) {
			console.log("Error while getting list of user types : " + error)
		}
		makeAjaxCall(args);
}

function returnNigranName(args,spanId)
{
		debugger;
		args["url"] = args.url, args["type"] = "GET"
		args["success"] = function(data, status, xhr) {			 
			debugger;
			document.getElementById(spanId).innerHTML = data.data["name"];
		}
		args["error"] = function(xhr, status, error) {
			console.log("Error while getting list of user types : " + error)
		}
		makeAjaxCall(args);
}


//filling form for edit and view data
function fillUpForms(args,type) {

	args["url"] = args.url, args["type"] = "GET"
	args["success"] = function(data, status, xhr) {
		debugger;
		repopulate(data);
	}

	args["error"] = function(xhr, status, error) {
		console.log("Error while getting list of user types : " + error)
	}

	makeAjaxCall(args)
}

function repopulate(oData) {
    $.each(oData.data, function(name, val) {
        var $el = $('[name="' + name + '"]'),
            type = $el.attr('type');
      
        switch (type) {
        
        case 'select':
        	$el.val(val);
            break;
            
        case 'hidden':
        	val!=null ? setValues(type, name, val): void(0);;
            break;

        default:
            $el.val(val);
        
        }
    });
}

function setValues(type, name, value) {
	  switch (name) {
      case 'image':
    	  document.getElementById('profileImage').src= value.substring(1, value.length);
          break;
      case 'id':
    	  document.getElementById('id').value= value;
          break;
	  }
	  
	  
}

function getBase64Image(element, imageElementId) {
	var file = element.files[0];
	var reader = new FileReader();

	reader.onloadend = function(e) {
		
		document.getElementById(imageElementId).src= e.target.result;
	
		var base64Image = reader.result.split(',');
		
		document.getElementById("image").value = base64Image[1];
	}
	
  reader.readAsDataURL(file);
}

function convertImgToDataURLviaCanvas(url, callback, outputFormat) {
	  var img = new Image();
	  img.crossOrigin = 'Anonymous';
	  img.onload = function() {
	    var canvas = document.createElement('CANVAS');
	    var ctx = canvas.getContext('2d');
	    var dataURL;
	    canvas.height = this.height;
	    canvas.width = this.width;
	    ctx.drawImage(this, 0, 0);
	    dataURL = canvas.toDataURL(outputFormat);
	    callback(dataURL);
	    canvas = null;
	  };
	  img.src = url;
	}

	function convertFileToDataURLviaFileReader(url, callback) {
	  var xhr = new XMLHttpRequest();
	  xhr.onload = function() {
	    var reader = new FileReader();
	    reader.onloadend = function() {
	      callback(reader.result);
	    }
	    reader.readAsDataURL(xhr.response);
	  };
	  xhr.open('GET', url);
	  xhr.responseType = 'blob';
	  xhr.send();
	}
	
function convertTobase64Img(img){
	debugger;
	 var imageUrl = img;
	  var convertType = 'FileReader';
	  var convertFunction = convertType === 'FileReader' ?
	    convertFileToDataURLviaFileReader :
	    convertImgToDataURLviaCanvas;

	  convertFunction(imageUrl, function(base64Img) {
		  var base64 = base64Img.split(',');
		  document.getElementById("image").value = base64[1];
	  });
}

function setCookie(cname, cvalue, exMinutes) {
    var d = new Date();
    d.setTime(d.getTime() + (exMinutes*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function delete_cookie( name ) {
	  document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
	}

function nestedLocationIds(id) {
	var newData;
	var args = buildAjaxArgs(locationsApiUrl+"/locations/chiledLocationIds/"+id+"/",'GET',"json","application/json",function(data, status, xhr){
		console.log(data)
		window.newData = data.data.join()
		return window.newData;
	},function(xhr, status, error){
		console.log(status)
	});
	return makeAjaxCall(args);
}


function displayLoader(status) {
	if(status){
		$('#loader').show();
	} else if(!status){
		$('#loader').hide();
	}
}