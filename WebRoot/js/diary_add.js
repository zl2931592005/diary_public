/*日志增加页的js方法*/

function add(){
	var consume = document.getElementById("consume");

	var tr = document.createElement("tr");

	var td1 = document.createElement("td");
	var cause = document.createElement("input");
	cause.setAttribute("type","text");
	cause.setAttribute("name","cause");
	td1.appendChild(cause);

	var td2 = document.createElement("td");
	var money = document.createElement("input");
	money.setAttribute("type","text");
	money.setAttribute("name","money");
	td2.appendChild(money);

	var td3 = document.createElement("td");	
	var select = document.createElement("select");
	select.setAttribute("name","manner");
	var option1 = document.createElement("option");
	option1.setAttribute("value","支付宝");
	var textNode1 = document.createTextNode("支付宝");
	var option2 = document.createElement("option");
	option2.setAttribute("value","微信");
	var textNode2 = document.createTextNode("微信");
	var option3 = document.createElement("option");
	option3.setAttribute("value","现金");
	var textNode3 = document.createTextNode("现金");
	option1.appendChild(textNode1);
	option2.appendChild(textNode2);
	option3.appendChild(textNode3);
	select.appendChild(option1);
	select.appendChild(option2);
	select.appendChild(option3);
	td3.appendChild(select);

	var td4 = document.createElement("td");
	var button = document.createElement("input");
	button.setAttribute("type","button");
	button.setAttribute("value"," - ");
	/*TODO这里要增加点击删除时的方法*/
	button.setAttribute("onclick","del(this)");
	td4.appendChild(button);

	tr.appendChild(td1);
	tr.appendChild(td2);
	tr.appendChild(td3);
	tr.appendChild(td4);

	consume.appendChild(tr);
}


function del(a){
	a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
}