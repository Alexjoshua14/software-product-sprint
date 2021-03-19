// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

/** A message obtained by contact form on portfolio website. */
public final class Message {

  // Id of the entity 
  private final long id;
  
  // Email address of the sender
  private final String email;

  // Message from sender
  private final String message;

  // Timestamp of when the message was sent
  private final long timestamp;

  public Message(long id, String email, String message, long timestamp) {
    this.id = id;
    this.email = email;
    this.message = message;
    this.timestamp = timestamp;
  }
}