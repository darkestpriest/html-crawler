HTML Crawler

How to run:

    ```java -cp html-crawler-1.0.0.jar <input_origin_file_path> <input_other_sample_file_path>```
    
You must get an output like this:

```
<div class="panel-body"> 
 <a class="btn btn-danger" href="#ok" title="Make-Button" onclick="javascript:window.close(); return false;"> Break everyone's OK </a> 
 <a class="btn btn-success" href="#check-and-ok" title="Make-Button" rel="done" onclick="javascript:window.okDone(); return false;"> Make everything OK </a> 
</div>
```
     