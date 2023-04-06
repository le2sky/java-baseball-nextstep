package calculator;

import java.util.LinkedList;
import java.util.Queue;

class Participants<T> {

  private final Queue<T> participants = new LinkedList<>();

  public Participants(Queue<T> participants) {
    if (participants.isEmpty()) {
      throw new IllegalArgumentException();
    }

    this.participants.addAll(participants);
  }

  public T nextParticipant() {
    return this.participants.poll();
  }

  public boolean isEmpty() {
    return participants.isEmpty();
  }
}