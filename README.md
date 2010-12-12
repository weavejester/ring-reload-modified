# reload-modified middleware

The reload-modified middleware automatically reloads namespaces when
their associated source files are modified.

## Example

    (use 'ring.middleware.reload-modified)
    
    (def app
      (wrap-reload-modified #'handler ["src"]))
