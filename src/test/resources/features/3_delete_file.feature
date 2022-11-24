Feature: Delete File
  Background: User authorized

  Scenario Outline: User can delete file from his dropbox folder
    Given I want to delete file by existing filepath "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/files/delete_v2"

    Examples:
      | filepath                        |
      | /photos/first.png  |
      | /photos/second.png |