Overview

This project implements a simple one-shot notification scheduler in Kotlin.
A notification is scheduled to run exactly once at a given time, without polling or time-comparison loops.

The scheduler works by:

Calculating the delay between now and the scheduled time

Sleeping efficiently

Executing the notification once

Discarding the task
