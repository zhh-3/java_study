#!/bin/bash  
  
list="ht-cadviewer.js ht-contextmenu.js ht-cssanimation.js ht-dashflow.js ht-dialog.js ht-edgetype.js ht-flow.js ht-forcelayout.js ht-form.js ht-historymanager.js ht-htmlnode.js ht-live.js ht-menu.js ht-modeling.js ht-obj.js ht-overview.js ht-palette.js ht-panel.js ht-propertypane.js ht-quickfinder.js ht-rulerframe.js ht-telecom.js ht-xeditinteractor.js"  
for i in $list;  
do   
curl -o $i  http://www.hightopo.com/guide/lib/plugin/$i
done 
