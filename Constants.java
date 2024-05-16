public enum Constants {
  ADD_OBJECT(1),
  REMOVE_OBJECT(2),
  OUTPUT_LIST(3),
  CHECK_EQUALS(4),
  EXIT(5);

  private int value;

  Constants(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
