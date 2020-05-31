#!/usr/bin/expect
set timeout 1000000
spawn git clone "$0"
expect "*yes*"
send "yes\r"
expect "#"
expect eof
