# task-manager

A small tool to manage batch tasks. The whole set of tasks are store in ```.params``` file. Completed batch is store in ```out/``` directory.
The tool will find out which tasks haven not been completed.

Completed tasks are indicated by the file name in ```out/``` directory. E.g, ```20-30.txt``` means task #20 to #29 (start from 0) has been completed. Extension doesn't matter. The content in the file doesn't matter. It may contain result of that batch, which is depends on the program that actually process the batch
