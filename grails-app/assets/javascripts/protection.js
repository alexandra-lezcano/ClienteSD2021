function neighSearchChanged(value){
    jQuery.ajax(
        {type:'POST',data:'find='+value, url:'/neighborhood/updateTable',success:function(data,textStatus){
                jQuery('#list-neighborhood').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
};