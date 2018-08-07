var playingui = {
    autovariable: function (options) {
        if (options != undefined) {
            if (typeof options == "string") {
                options=options.split(',');
                for (var i = 0; i < options.length; i++) {
                    eval("$" + options[i] + "=$('#" + options[i] + "');");
                }
            }
        }
    },
    buildgrid:function(grid)
    {
    	 var html ='';
    	 var json=grid.json;
    	 var fields=grid.data;
       	 for (var i = 0; i < json.length; i++) {
       	 		html += "<tr>";
       	 		for (var j = 0; j < fields.length; j++){
       	 			var name=json[i][fields[j].name];
       	 			var field=fields[j];
       	 			var currentfield=json[i];
       	 			if(field.type=='opfield')
       	 			{
       	 				html += getTbodyTd(field.value(currentfield));
       	 			}
       	 			else{
           	 			if (field.value!=undefined && typeof field.value=="function")
           	 			{
           	 				html += getTbodyTd(field.value(currentfield));
           	 			}
           	 			else
           	 			{
           	 				if(field.type == 'date'){
           	 				    //html += getTbodyTd(baidu.date.format(new Date(name),'yyyy-MM-dd'));
           	 				    html += getTbodyTd(name);
	           	 			}
	           	 			else{
		           	 			html += getTbodyTd(name);
		           	 		}
           	 			}
       	 			}
           	 		grid.onloading(currentfield);
       	 		}
       	 		html += "</tr>";
       	 }
       	 $tbody.show();
         $tbodyPage.show();
         $tbodyList.html(html);
         //成功获取数据绑定page控件
         bindPage();
    }
	
};
 