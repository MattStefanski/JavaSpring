#!/usr/bin/env bash



fail() {
  echo "There were errors"
}

if /bin/bash /Users/mateusz/tasks/runcrud.sh; then
    xdg-open http://localhost:8080/crud/v1/task/getTasks
else
   fail
fi